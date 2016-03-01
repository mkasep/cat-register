package ttu.idu0080.rest.service;

import ttu.idu0080.rest.data.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class DataService  {




	@PersistenceContext
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}


	public Cat getCatById(long id)  {


		Cat node = null;
		try {


			Query q =  em
					.createQuery(
							"select c from Cat c where c.id = :id")
							.setParameter("id", id);
			node = (Cat) q.getSingleResult();


		}

		catch(Exception ex)
		{
			System.out.println("DataService.getCatById():"+ ex.getMessage());
		
		}

		return node;
	}


	
	
	
	public List<Cat> getAllCats()  {


		List<Cat> cat_list = null;
		try {


			Query q =  em
					.createQuery(
							"select c from Cat c ");
			cat_list = (List<Cat>)  q.getResultList();


		}

		catch(Exception ex)
		{
			System.out.println("DataService.getAllCats():"+ ex.getMessage());
		}

		return cat_list;
	}

	
	
	public Cat update(Cat cat)  {


		System.out.println("cat update , cat character: " + cat.getCharacter());
		try {

			em.merge(cat);
			em.flush();

		}

		catch(Exception ex)
		{
			System.out.println("DataService.update():"+ ex.getMessage());
		}

		return cat;
	}

	
	public Cat save(Cat cat) {

		System.out.println("new cat insert , cat character: " + cat.getCharacter());

		try {
			
			em.persist(cat);


		}

		catch(Exception ex)
		{
			System.out.println("DataService.save():"+ ex.getMessage());
		}

		return cat;
	}
	
	public void delete(long id) {

		System.out.println("DELETE ");

		try {
			
	          Cat cat =  em.find(Cat.class,id);
	          em.remove(cat);


		}

		catch(Exception ex)
		{
			System.out.println("DataService.delete():"+ ex.getMessage());
		}


	}
	
	public  List<Cat> searchByName(String s_character)  {

		List<Cat> cats = null;

		try {

			String sql = "from Cat c where upper(c.name) like upper(:name) order by c.name";
            
			Query q = em.createQuery(sql);	
			q.setParameter("name", s_character+"%") ;
			cats =  (List<Cat>) q.getResultList();
                        System.out.println("Otsingu tulemusi:" + cats.size());

		}

		catch(Exception ex)
		{
			System.out.println("DataService.searchByCharacter():" + ex.getMessage());

		}

		return cats;
	}
	
	
}
