package com.tiger.javase.study.lambda;

import javax.swing.JButton;

public class LambdaStudy {
	public static void main(String[] args) {
		runThreadUseLambda();
		buttonUseLambda();
	}

	private static void buttonUseLambda() {
		JButton jb = new JButton();
		jb.addActionListener((e) -> System.out.println("bb"));
	}

	private static void runThreadUseLambda() {
		new Thread(() -> System.out.println("aa")).start();
	}
}
