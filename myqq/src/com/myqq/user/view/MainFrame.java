package com.myqq.user.view;

import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import com.myqq.entity.User;
import com.myqq.message.view.TreeMouseListener;
import com.myqq.user.service.UserService;

public class MainFrame extends JFrame{
	public User myself;
	public List<User> friends;
	public HashMap<Integer, ChatFrame> chatingFrame = new HashMap<Integer,ChatFrame>();
	
	JScrollPane userListPane = null;
	JTree userTree = null;
	DefaultTreeModel treeModel = null;
	DefaultMutableTreeNode rootNode = null;
	
	public MainFrame(User u){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myself = u;
		//定义总结点
		rootNode = new DefaultMutableTreeNode("我的好友");
		//装载总结点
		treeModel = new DefaultTreeModel(rootNode);
		//添加总结点
		userTree = new JTree(treeModel);
		//定义展开
		userTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		userTree.setShowsRootHandles(true);
		
		userListPane = new JScrollPane(userTree);
		
		friends = new UserService().listFriends(myself.getQqnum());
		for(User friend : friends){
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(friend);
			rootNode.add(node);
		}
		
		userTree.addMouseListener((MouseListener) new TreeMouseListener(this,userTree,myself));
		
		this.getContentPane().add(userListPane);
		this.setTitle(myself.getNickName());
		this.setSize(300, 550);
		this.setVisible(true);
	}
}
