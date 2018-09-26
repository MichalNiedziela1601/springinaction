package org.springidol;

import com.springidol.BeanConfig;
import com.springidol.MindReader;
import com.springidol.Performer;
import com.springidol.Thinkier;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfig.class)
public class AspectTest {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    MindReader magician;

    @Autowired
    Thinkier volounteer;

    @Test
    public void billyShouldDoPerform() throws Exception {
        Performer eddie = (Performer) ctx.getBean("eddie");
        eddie.perform();
    }

    @Test
    public void magicianShouldCatchThougts() throws Exception {
        volounteer.thinkOfSomething("Dama Pik");
        assertEquals("Dama Pik", magician.getThoughts());
    }
}
