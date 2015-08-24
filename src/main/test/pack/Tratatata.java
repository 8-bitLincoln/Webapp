package pack;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pro.Dao.CoordinateDao;
import pro.Model.Coordinate;
import pro.TestSPring.bit8;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class Tratatata {


    @Autowired
    CoordinateDao CoordinateDao;

    @Autowired
    bit8 ddd;


    @Test
    public void testSMTH() {
        int a=5;


        CoordinateDao.save(new Coordinate("nick", new Double(5), new Double(4)));
        ddd.tratata();

    }
}
