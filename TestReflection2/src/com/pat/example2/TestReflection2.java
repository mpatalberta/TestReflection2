package com.pat.example2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflection2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("TestReflection2");
		
        Class<?> myruntimeclass=null;
		try {
			
			myruntimeclass= Class.forName("com.pat.example2.MyRunTimeClass");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// create the object with the default constructor
		
		Object myruntimeclassobj = null;
	    Field f=null;
       try {
		myruntimeclassobj = myruntimeclass.newInstance();
		// object constructed now find a set method with parameter of a string
			Class c;
			c = myruntimeclassobj.getClass();
			String s1;
			
			s1 = doSet(c,myruntimeclassobj,"hellopatty");
			System.out.println("afterset>"+s1+"<");
			s1 = doGet(c,myruntimeclassobj);
			System.out.println("afterget>"+s1+"<");
			
       } catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
       } catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
       }
		
       
       
       
        // example create the object at runtime with a string passed in on the constructor       
		Object myruntimeclassobj2 = null;
   	   
			try {
				String s1;
				Class c;
				
				myruntimeclassobj2 = myruntimeclass.getConstructor(String.class).newInstance("Hello Pat");
				c = myruntimeclassobj2.getClass();
				
				s1 = doGet(c,myruntimeclassobj2);
				System.out.println("afterget>"+s1+"<");
				
				s1 = doSet(c,myruntimeclassobj2,"hellopatty");
				System.out.println("afterset>"+s1+"<");
				
				s1 = doGet(c,myruntimeclassobj2);
				System.out.println("afterget>"+s1+"<");
				
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// object constructed now find a set method with parameter of a string
			
	
       
		System.out.println("exiting");
	}
	
	public static String doGet(Class c, Object obj) {
		String sRes =null;
		Method[] m;
		m = c.getMethods();
		for(int i = 0;i<m.length;i++)
		{	

            	if(m[i].getName().matches("Get"))
            	{
						try {
							sRes = (String)m[i].invoke(obj);
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
            	}

		}
		return sRes;
	}

	public static String doSet(Class c,Object obj ,String s)
	{
		String sRes =null;
		Method[] m;
		m = c.getMethods();
		for(int i = 0;i<m.length;i++)
		{	

            	if(m[i].getName().matches("Set"))
            	{
						try {
							sRes = (String)m[i].invoke(obj, "hellopatty");
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
            	}

		}
		
		return sRes;
	}
	

	

}
