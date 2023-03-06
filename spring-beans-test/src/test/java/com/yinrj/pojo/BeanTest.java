package com.yinrj.pojo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author yinrongjie
 * @version 1.0
 * @date 2023/2/28
 * @description
 */
public class BeanTest {
	@Test
	public void testXmlBeanFactory() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("student-bean.xml"));
		Student student = (Student) beanFactory.getBean("student");
		Assert.assertNotNull(student);
		Assert.assertSame(10, student.getId());
		Assert.assertEquals("testName", student.getName());
	}

	@Test
	public void testBeanFactory() {
		Resource resource = new ClassPathResource("student-bean.xml");
		BeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
		reader.loadBeanDefinitions(resource);
		Student student = (Student) beanFactory.getBean("student");
		Assert.assertNotNull(student);
		Assert.assertSame(10, student.getId());
		Assert.assertEquals("testName", student.getName());
	}
}
