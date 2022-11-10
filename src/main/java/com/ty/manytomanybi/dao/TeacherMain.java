package com.ty.manytomanybi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomanybi.dto.Student;
import com.ty.manytomanybi.dto.Teacher;



public class TeacherMain {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("abhi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student1 = new Student();
		student1.setName("abhishek");
		student1.setAge(9);
		student1.setStandard("3rd");

		Student student2 = new Student();
		student2.setName("ganesh");
		student2.setAge(10);
		student2.setStandard("4th");

		Student student3 = new Student();
		student3.setName("gnanesh");
		student3.setAge(14);
		student3.setStandard("8th");

		Teacher t1 = new Teacher();
		t1.setName("Shiv");
		t1.setGender("Male");
		t1.setSubject("Science");
		List<Student> list1 = new ArrayList<Student>();
		list1.add(student1);
		list1.add(student3);
		t1.setStudent(list1);

		Teacher t2 = new Teacher();
		t2.setName("umesh");
		t2.setGender("Male");
		t2.setSubject("java");
		List<Student> list2 = new ArrayList<Student>();
		list2.add(student1);
		list2.add(student2);
		t2.setStudent(list2);

		List<Teacher>ls1=new ArrayList<Teacher>();
		ls1.add(t2);
		ls1.add(t1);

		student1.setTeacher(ls1);
		student2.setTeacher(ls1);
		student3.setTeacher(ls1);

		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);
		entityManager.persist(t1);
		entityManager.persist(t2);

		entityTransaction.commit();

	}

}

