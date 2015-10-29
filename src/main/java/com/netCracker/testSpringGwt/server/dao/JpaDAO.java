package com.netCracker.testSpringGwt.server.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;

public abstract class JpaDAO<K, E> extends JpaDaoSupport {
	protected Class<E> entityClass;

	@SuppressWarnings("unchecked")
	public JpaDAO() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
	}

	public void persist(E entity) {
		getJpaTemplate().persist(entity);
	}

	public void remove(E entity) {
		getJpaTemplate().remove(entity);
	}

	public E merge(E entity) {
		return getJpaTemplate().merge(entity);
	}

	public void refresh(E entity) {
		getJpaTemplate().refresh(entity);
	}

	public E findById(K id) {
		return getJpaTemplate().find(entityClass, id);
	}

	public E flush(E entity) {
		getJpaTemplate().flush();
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<E> findAllMetaphone(final String customerFirstNameMetaphone, final String customerLastNameMetaphone) {

		Object findRes = getJpaTemplate().execute(new JpaCallback() {
			public Object doInJpa(EntityManager em) throws PersistenceException {
				Query q = em.createQuery("SELECT h FROM " + entityClass.getName() + " h INNER JOIN h.customerType a WHERE first_name_metaphone='"
						+ customerFirstNameMetaphone + "' AND last_name_metaphone='" + customerLastNameMetaphone + "' ORDER BY modified_when DESC");

				return q.getResultList();
			}
		});

		return (List<E>) findRes;

	}

	@SuppressWarnings("unchecked")
	public List<E> findLastModifed(final int maxResult) {

		Object findRes = getJpaTemplate().execute(new JpaCallback() {
			public Object doInJpa(EntityManager em) throws PersistenceException {
				Query q = em.createQuery("SELECT h FROM " + entityClass.getName() + " h INNER JOIN h.customerType a ORDER BY modified_when DESC");

				return (q.setMaxResults(maxResult)).getResultList();
			}
		});

		return (List<E>) findRes;
	}

}
