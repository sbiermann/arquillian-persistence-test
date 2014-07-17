package org.example.entity.persistencetest;


import org.example.entity.Parent;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.descriptor.api.Descriptors;
import org.jboss.shrinkwrap.descriptor.api.persistence10.PersistenceDescriptor;

import java.io.File;



/**
 * Created by sbn on 24.06.2014.
 */
public class PersistenceDeployments {


    public static PersistenceDescriptor descriptor() {
        return Descriptors.create(PersistenceDescriptor.class)
                .createPersistenceUnit()
                .name("test")
                .excludeUnlistedClasses(false)
                .getOrCreateProperties()
                .createProperty()
                .name("hibernate.hbm2ddl.auto")
                .value("create-drop")
                .up()
                .createProperty()
                .name("hibernate.show_sql")
                .value("true")
                .up()
                .up()
                .jtaDataSource("java:jboss/datasources/ExampleDS")
                .up();
    }

    public static WebArchive createJPADeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackage(Parent.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource(new StringAsset(
                        PersistenceDeployments.descriptor().exportAsString()), "META-INF/persistence.xml")
               ;

        //.addAsLibraries(PomReader.getPomFiles());

    }
}
