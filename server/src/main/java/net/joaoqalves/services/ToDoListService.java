package net.joaoqalves.services;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import net.joaoqalves.configurations.ToDoListConfiguration;
import net.joaoqalves.resources.ToDoListResource;
import org.eclipse.jetty.servlets.CrossOriginFilter;

public class ToDoListService extends Service<ToDoListConfiguration> {
    public static void main(String[] args) throws Exception {
        new ToDoListService().run(new String[] { "server" });
    }

    @Override
    public void initialize(Bootstrap<ToDoListConfiguration> bootstrap) {
        bootstrap.setName("todo");
    }

    @Override
    public void run(ToDoListConfiguration configuration, Environment environment) throws Exception {
        environment.addFilter(CrossOriginFilter.class, "/*")
                .setInitParam("allowedOrigins", "*")
                .setInitParam("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin")
                .setInitParam("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        environment.addResource(new ToDoListResource());
    }
}
