package com.terradatum;

import com.terradatum.business.AgentContactInfoBean;
import com.terradatum.entity.AgentContactInfoObject;
import com.terradatum.entity.AgentIdObject;
import com.terradatum.entity.PhoneNumberObject;
import com.terradatum.util.JULProducer;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.as.cli.CommandContext;
import org.jboss.as.cli.scriptsupport.CLI;
import org.jboss.as.process.protocol.StreamUtils;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Logger;

/**
 * Created by rbellamy on 12/21/15.
 */
@RunWith(Arquillian.class)
public class TestAgentContactInfoBean {

    @EJB()
    private AgentContactInfoBean agentContactInfo;

    @Inject
    private Logger log;

    @Deployment
    public static Archive<?> createDeployment() {
        processCliFile(new File("src/test/eclipselink-module/wildfly-fix-eclipselink-auto-scan.cli"));

        WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(AgentContactInfoBean.class, AgentContactInfoObject.class, AgentIdObject.class,
                        PhoneNumberObject.class, JULProducer.class)
                .addAsResource(new File("src/main/resources/META-INF/persistence.xml"), "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(archive.toString(true));
        return archive;
    }

    @Test
    public void getAgentContactInfo() {
        log.info("Starting the test 'getAgentContactInfo()'");
        Assert.assertNotNull("Injected object should not be null.", agentContactInfo);
        Assert.assertEquals("Should say 'Hello World!'.", "Hello World!", agentContactInfo.sayHello());
    }

    private static void processCliFile(File file) {
        CLI cli = CLI.newInstance();
        cli.connect("localhost", 9990, null, null);
        CommandContext commandContext = cli.getCommandContext();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (commandContext.getExitCode() == 0 && !commandContext.isTerminated() && line != null) {
                commandContext.handleSafe(line.trim());
                line = reader.readLine();
            }
        } catch (Throwable e) {
            throw new IllegalStateException("Failed to process file '" + file.getAbsolutePath() + "'", e);
        } finally {
            StreamUtils.safeClose(reader);
        }
    }
}
