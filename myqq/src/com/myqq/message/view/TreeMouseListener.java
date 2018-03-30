package com.myqq.message.view;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import com.myqq.entity.User;
import com.myqq.user.view.ChatFrame;
import com.myqq.user.view.MainFrame;

public class TreeMouseListener {
	JTree tree;
	User myself;
	MainFrame mainFrame;
	private User another;
	public TreeMouseListener(MainFrame mainFrame, JTree tree,User u) {
		this.tree = tree;
		this.myself = u;
		this.mainFrame = mainFrame;
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getModifiers() == InputEvent.BUTTON1_MASK  && arg0.getClickCount() == 2) {
			//判断获得节点位置
			int n = tree.getRowForLocation(arg0.getX(), arg0.getY());
			if (n < 0) {
				return;
			}
			//获得节点
			TreePath selTree = tree.getPathForRow(n);
			DefaultMutableTreeNode selNode = (DefaultMutableTreeNode) selTree.getLastPathComponent();
			//判断是否为叶子节点
			if (selNode.isLeaf()) {
				//获得传入的类 强转
				another = (User)selNode.getUserObject();
				int qqnum = another.getQqnum();
				HashMap<Integer, ChatFrame>chatFrames = mainFrame.chatingFrame;
				boolean isExit = false;
				Iterator i = chatFrames.keySet().iterator();
				while (i.hasNext()) {
					if (qqnum == Integer.parseInt(i.next().toString())) {
						isExit = true;
						break;
					}
				}
				if (!isExit) {
					ChatFrame chatFrame = new ChatFrame(myself, another);
					mainFrame.chatingFrame.put(qqnum, chatFrame);
				}
			}
		}
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
