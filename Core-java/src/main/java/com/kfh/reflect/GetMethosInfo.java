package com.kfh.reflect;

/**
 * 这个类告诉我们了如何获取方法信息
 * 
 * @author kfh
 *
 */
public class GetMethosInfo {

	public static void main(String[] args) {

		Class c1 = int.class;// int的类类型
		Class c2 = String.class;// String的类类型
		Class c3 = double.class;
		Class c4 = Double.class;

		/**
		 * 也就是说类类型在表示的时候是XX.class
		 */
		Class c5 = void.class;
		/**
		 * 此处要注意的是 基本数据类型包括void关键字都存在类类型
		 */
		// Class的基本方法
		System.out.println(c1.getName());// 打印类类型的全称
		System.out.println(c2.getName());
		System.out.println(c2.getSimpleName());// 简略打印即不带包名的名称
		System.out.println(c3.getName());
		System.out.println(c4.getName());
		System.out.println(c5.getName());

	}

}
