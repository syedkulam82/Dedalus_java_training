package com.mph.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectClass {

	// @Before("allGetters()")
	// public void logMessage()
	// {
//		System.out.println("logging now");
	// }

	/*
	 * @Before("allCarMethods()") public void carMethods() {
	 * System.out.println("I am for Car"); }
	 */
	@Pointcut("execution(* com.mph.aop.Car.set*(..))")
	public void allSetters() {
	}

	/*
	 * @Pointcut("execution(public * get*())") public void allGetters() { }
	 * 
	 * @Pointcut("within(com.mph.aop.Car)") public void allCarMethods() { }
	 */
	/*
	 * @AfterReturning("args(aa)") public void MethodWithoutException(String aa) {
	 * System.out.println("Method executed successfully" + aa); }
	 */

	@AfterThrowing("args(aa)")
	public void MethodWithException(String aa) {
		System.out.println("Method with Runtime Exception" + aa);
	}
/*
	@Around("allSetters()")
	public void myAroundAdvice(ProceedingJoinPoint joinPoint) {

		try {
			System.out.println("Before Around Advice");
			System.out.println(joinPoint.getTarget());
			System.out.println(joinPoint.getArgs());
			System.out.println(joinPoint.getSignature());
			System.out.println(joinPoint.getSourceLocation());
			joinPoint.proceed();

			System.out.println("After Around Advice");
		} catch (Throwable e) {
			System.out.println("After throwing");
			e.printStackTrace();
		} finally {
			System.out.println("From finally block");
		}

	}
	*/
}
