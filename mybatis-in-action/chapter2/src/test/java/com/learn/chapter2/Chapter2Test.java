package com.learn.chapter2;

import org.apache.ibatis.session.SqlSession;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.learn.chapter2.mapper.RoleMapper;
import com.learn.chapter2.po.Role;
import com.learn.chapter2.util.SqlSessionFactoryUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Chapter2Test {

	@Test
	public void testInsert() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSession();

			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = new Role();
			role.setId(1L);
			role.setRoleName("测试1");
			role.setNote("测试1");
			int result = roleMapper.insertRole(role);
			System.out.println(result);

			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Test
	public void testSelect() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSession();

			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = roleMapper.getRole(1L);
			System.out.println(role.toString());

			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Test
	public void testSelect2() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSession();

			Role role = sqlSession.selectOne("com.learn.chapter2.mapper.RoleMapper.getRole2", 1L);
			System.out.println(role.toString());

			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Test
	public void testdelete() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSession();

			int result = sqlSession.delete("com.learn.chapter2.mapper.RoleMapper.deleteRole", 1L);
			System.out.println(result);

			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}
