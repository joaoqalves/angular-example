package net.joaoqalves.resources;

import com.yammer.metrics.annotation.Timed;
import net.joaoqalves.domain.NewTask;
import net.joaoqalves.domain.Task;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Path("/todo")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class ToDoListResource {

    private List<Task> tasks = new ArrayList<>();

    @GET
    @Path("/")
    @Timed
    public List<Task> get() {
        return this.tasks;
    }

    @POST
    @Path("/add")
    @Timed
    public List<Task> add(@Valid NewTask newTask) {
        Long now = System.currentTimeMillis();
        this.tasks.add(new Task(UUID.randomUUID(), newTask.getTitle(), now, now));
        return this.tasks;
    }

    @PUT
    @Path("/edit/{taskId}")
    @Timed
    public List<Task> edit(@PathParam("taskId") UUID taskId, @Valid Task task) {
        Iterator<Task> it = this.tasks.iterator();

        while(it.hasNext()) {
            Task t = it.next();
            if(t.getId().equals(taskId)) {
                t.setTitle(task.getTitle());
            }
        }

        return this.tasks;
    }

    @PUT
    @Path("/reorder")
    @Timed
    public List<Task> reorder(@Valid List<Task> tasks) {
        this.tasks = tasks;
        return this.tasks;
    }

    @DELETE
    @Path("/remove/{taskId}")
    public List<Task> remove(@PathParam("taskId") UUID taskId) {
        Iterator<Task> it = this.tasks.iterator();

        while(it.hasNext()) {
            Task t = it.next();
            if(t.getId().equals(taskId)) {
                it.remove();
            }
        }

        return this.tasks;
    }

}
