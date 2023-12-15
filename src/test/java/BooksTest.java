import org.example.Books;
import org.example.BooksDao;
import org.example.Session;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class BooksTest {
    @Test
    public void testSaveCar() {

        Session session = Mockito.mock(Session.class);

        Books car = new Books();
        car.setName("qwe");
        car.setType("asd");
        car.setVender("asd");

        Mockito.when(session.save(car)).thenReturn(1L);

        Long id = session.save(car);

        Assert.assertNotNull(id);
        Assert.assertEquals(1L, id.longValue());
    }

    @Mock
    BooksDao booksDao;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public  void testNothing(){
        Mockito.doNothing().when(booksDao).saveCars(anyString(), anyInt());

        booksDao.saveCars("car", 0);
        Mockito.verify(booksDao).saveCars(anyString(), anyInt());
    }

    @Test
    public void testThrow(){
        Mockito.doThrow(NullPointerException.class).when(booksDao).saveCars(anyString(), anyInt());

        Assertions.assertThrows(NullPointerException.class, () ->{
            booksDao.saveCars("car", 0);
        });
    }


    @Test
    public void test_withDoAnswer(){
        Mockito.doAnswer(invocationOnMock -> {
            String carsName = invocationOnMock.getArgument(0);
            int index = invocationOnMock.getArgument(1);

            Assertions.assertEquals(carsName, "car");
            Assertions.assertEquals(index, 0);
            return null;
        }).when(booksDao).saveCars(anyString(), anyInt());

        booksDao.saveCars("car", 0);
    }

    @Test
    public void test_CallRealMethod(){
        Mockito.doCallRealMethod().when(booksDao).saveCars("car", 0);

        booksDao.saveCars("car", 0);
        Mockito.verify(booksDao).saveCars(anyString(), anyInt());

    }
}

