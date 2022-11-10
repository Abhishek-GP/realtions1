package com.ty.manytomanybi.dto;

	import java.util.List;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.JoinTable;
	import javax.persistence.ManyToMany;

	@Entity
	public class Student {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
		private String standard;
		private int age;
		@ManyToMany@JoinTable(joinColumns= {@JoinColumn},inverseJoinColumns = {@JoinColumn(name="id")})
		private List<Teacher>teacher;
		
		public List<Teacher> getTeacher() {
			return teacher;
		}
		public void setTeacher(List<Teacher> teacher) {
			this.teacher = teacher;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getStandard() {
			return standard;
		}
		public void setStandard(String standard) {
			this.standard = standard;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		

	}

