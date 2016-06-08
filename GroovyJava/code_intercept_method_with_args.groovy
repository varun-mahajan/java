import org.bytegeeks.learn.*;
tm = GroovyMain.getBean("testMethods")

def origMethod = TestMethods.metaClass.getMetaMethod('testTwoArg', [String, String] as Class[])


tm.metaClass.testTwoArg = { String a, String b -> 
  b = b + ". THIS LAST IS APPENDED FROM GROOVY"
  origMethod.invoke(tm,a,b)
}

tm.testTwoArg("varun", "mahajan");
