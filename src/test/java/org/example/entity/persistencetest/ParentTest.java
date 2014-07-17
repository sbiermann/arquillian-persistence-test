package org.example.entity.persistencetest;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ParentTest {


    @Deployment
    public static WebArchive createDeployment() {
        WebArchive war = PersistenceDeployments.createJPADeployment();
        System.out.println(war.toString(true));
        return war;
    }

    @Test
    @UsingDataSet("parent.yml")
    @Cleanup(phase = TestExecutionPhase.AFTER, strategy = CleanupStrategy.STRICT)
    public void removing_property() {

    }

}
