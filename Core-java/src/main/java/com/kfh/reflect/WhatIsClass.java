package com.kfh.reflect;

import org.omg.Messaging.SyncScopeHelper;

/**
 * 认识java.lang.Class 是什么
 * 
 * @author kfh
 *
 */
public class WhatIsClass {
	public static void main(String[] s) {
		
		/*System.out.println(args);
		System.out.println(args.length);*/
		
		
		// Foo的对象如何表示？
		Foo foo1 = new Foo();// foo1就表示出来了;
		// 现在我们说Foo这个类 本身也是一个实例对象，是java.lang.Class的实例对象,如何表示呢？
		// Class;点进去看一下源码
		/*
		 * Constructor. Only the Java Virtual Machine creates Class objects.
		 */
		// private Class() {}
		// 任何一个类都是Class的实例对象,这个实例对象有三种表示方式

		// 第一种
		Class c1 = Foo.class;// 实际在告诉我们任何一个类都有一个隐含的静态成员变量class

		// 第二种 已经知道了该类的对象通过getClass方法
		Class c2 = foo1.getClass();

		/**
		 * 这c1和c2就称之为Foo类的类类型(class type) </br>
		 * -->结论：万事万物皆对象， </br>
		 * 类也是对象，是Class类的实例对象 </br>
		 * 这个对象我们称之为该类的类类型 </br>
		 */
		System.out.println(c1 == c2);

		// 第三种表达方式
		Class c3 = null;
		try {
			c3 = Class.forName("com.kfh.reflect.Foo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(c2 == c3);

		// 还有一点：我们完全可以通过该类的类类型创建该类的对象实例 即：
		// 在本例中就是可以通过c1 c2 c3 创建Foo的实例
		try {
			Foo foo = (Foo) c1.newInstance();// 前提是有无参的构造方法
			/**
			 * 此处这个c1如果是A类的类类型，创建的就是A类的对象 <br>
			 * 如果是B类的类类型，创建的就是B类的对象
			 */
			foo.print();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class Foo {
	void print() {
		System.out.println("I am foo!");
	}
}