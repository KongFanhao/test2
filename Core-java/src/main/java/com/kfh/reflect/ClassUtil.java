package com.kfh.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Class工具类
 * 
 * @author kfh
 *
 */
public class ClassUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 参数是一个对象<br>
	 * 获取该对象所属类的信息<br>
	 * 打印类的信息，成员函数
	 * 
	 * @param o
	 */
	public static void printClassMessage(Object obj) {
		// 要获取类的信息，首先要获取类的类类型
		// 有三种 类名.class 对象.getclass() Class.forName()
		// 因为参数是一个对象
		Class c = obj.getClass();// 传递的是哪个子类的对象，c就是哪个子类的类类型
		// 获取类的名称
		System.out.println("类的名称是:" + c.getName());
		/**
		 * 获取类的成员函数 在java中方法是Method的对象<br>
		 * 一个成员方法就是一个Method对象<br>
		 * getMethod()获得的是所有的public的函数，包括父类继承的方法<br>
		 * getDeclaredMethods()这个方法获得的是所有该类自己声明的方法，不问访问权限
		 */
		Method[] methods = c.getMethods();
		// Method[] declaredMethods = c.getDeclaredMethods();
		// 之后获取这些成员方法的信息
		for (int i = 0; i < methods.length; i++) {
			// 获取方法返回值的类类型
			Class<?> returnType = methods[i].getReturnType();
			System.out.print(returnType.getName() + " ");
			// 获取方法名称
			System.out.print(methods[i].getName() + "(");
			// 获取参数列表类类型
			Class<?>[] parameterTypes = methods[i].getParameterTypes();
			for (Class<?> class1 : parameterTypes) {
				System.out.print(class1.getName() + ", ");
			}
			System.out.println(")");
		}
	}

	/**
	 * 打印类的成员变量信息
	 * 
	 * @param obj
	 */
	public static void printFieldMessage(Object obj) {
		/**
		 * 成员变量也是对象 java.lang.reflect.Field这个类<br>
		 * Field类封装了关于成员变量的操作 <br>
		 * getFields() 方法获取的是所有的public的成员变量的信息<br>
		 * getDeclaredFields获取的是该类自己声明的成员变量的信息
		 * 
		 */
		Class<? extends Object> c = obj.getClass();
		Field[] fields = c.getFields();
		for (Field field : fields) {
			// 得到成员变量类型的类类型 如果得到的是int，则结果就是int.class
			Class<?> type = field.getType();
			// 得到成员变量类型的名称
			String typeName = type.getName();
			// 得到成员变量的名称
			String fieldName = field.getName();
			System.out.println("成员变量类型的名称：" + typeName);
			System.out.println("成员变量的名称：" + fieldName);
		}
	}

	/**
	 * 打印对象构造方法的信息
	 * 
	 * @param obj
	 */
	public static void printConMessage(Object obj) {
		// 构造方法也是对象，java.lang.Constructor中封装了构造方法的信息
		// getConstructors获取所有的public的构造方法
		// getDeclaredCOnstructors获取所有的自己声明的构造方法
		Class<? extends Object> c = obj.getClass();
		Constructor<?>[] constructors = c.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			String name = constructor.getName();
			System.out.print(name + "(");
			// 获取构造方法的参数列表
			Class<?>[] parameterTypes = constructor.getParameterTypes();
			for (Class<?> class1 : parameterTypes) {
				System.out.print(class1.getName() + ", ");
			}
			System.out.println(")");
		}
	}
}
