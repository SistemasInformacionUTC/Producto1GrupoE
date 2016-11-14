package models;

import java.util.*;

import javax.persistence.*;

import com.avaje.ebean.Model;
import com.avaje.ebean.PagedList;

import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;
import com.avaje.ebean.Model.Find;

@Entity 

public class DiscoDuro extends Model{

	 private static final long serialVersionUID = 1L;

		@Id
	    public Long id;
	    
	    @Constraints.Required
	    public int nombre;
	    
	    
	    @Constraints.Required
	    public int descripcion;
	    
	    
	    @ManyToOne
	    public Computer computer;
	    
	    
	    
	    /**
	     * Generic query helper for entity Computer with id Long
	     */
	    public static Find<Long,DiscoDuro> find = new Find<Long,DiscoDuro>(){};
	    
	    /**
	     * Return a paged list of computer
	     *
	     * @param page Page to display
	     * @param pageSize Number of computers per page
	     * @param sortBy Computer property used for sorting
	     * @param order Sort order (either or asc or desc)
	     * @param filter Filter applied on the name column
	     */
	    public static PagedList<DiscoDuro> page(int page, int pageSize, String sortBy, String order, String filter) {
	        return
	            find.where()
	                .ilike("nombre", "%" + filter + "%")
	                .orderBy(sortBy + " " + order)
	                .fetch("descrpcion")
	                .findPagedList(page, pageSize);
	    }
}
