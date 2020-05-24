package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Library;
import lt.vu.persistence.LibraryDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/libraries")
public class LibraryController {

    @Inject @Setter @Getter
    private LibraryDAO libraryDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLibraryById(@PathParam("id") Integer id) {
        Library library = libraryDAO.findOne(id);

        if (library == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        LibraryModel libraryModel = new LibraryModel();
        libraryModel.setName(library.getName());
        libraryModel.setAddress(library.getAddress());

        return Response.ok(libraryModel).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createLibrary(LibraryModel libraryModel) {
        Library library = new Library();

        library.setName(libraryModel.name);
        library.setAddress(libraryModel.address);

        libraryDAO.persist(library);

        return Response.ok().build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateLibrary(@PathParam("id") Integer id, LibraryModel newLibrary) {
        Library currentLibrary = libraryDAO.findOne(id);
        if (currentLibrary == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        currentLibrary.setName(newLibrary.name);
        currentLibrary.setAddress(newLibrary.address);

        libraryDAO.update(currentLibrary);

        return Response.ok().build();
    }
}
