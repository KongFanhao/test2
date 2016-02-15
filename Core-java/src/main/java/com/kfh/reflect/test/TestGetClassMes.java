package com.kfh.reflect.test;

import com.kfh.reflect.ClassUtil;

import junit.framework.TestCase;

public class TestGetClassMes extends TestCase {

	public void testPrintClassMes() {

		String s = "hello";
		ClassUtil.printClassMessage(s);

		Integer i = 1;
		ClassUtil.printClassMessage(i);
		System.out.println("=============");
		ClassUtil.printFieldMessage(i);

		System.out.println("===============");
		ClassUtil.printConMessage(s);
		Kfh k = new Kfh();
		Class<? extends Kfh> class1 = k.getClass();
		System.out.println(class1.getName());
	}
}
