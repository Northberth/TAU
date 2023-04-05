import org.example.Norris;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NorrisTests {
    Norris norris = mock(Norris.class);

    String url = "https://api.chucknorris.io/jokes";
    @Test
    public void randomJokeTest(){
        when(norris.randomJoke(url+"/random")).thenReturn("{\n" +
                "    \"categories\": [],\n" +
                "    \"created_at\": \"2020-01-05 13:42:21.795084\",\n" +
                "    \"icon_url\": \"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\n" +
                "    \"id\": \"UuaDu58eTPGgB2pq2DNz3Q\"\n" +
                "    \"updated_at\": \"2020-01-05 13:42:21.795084\"\n" +
                "    \"url\": \"https://api.chucknorris.io/jokes/UuaDu58eTPGgB2pq2DNz3Q\"\n" +
                "    \"value\": \"BB guns are considered nonlethal weapons...except when in the hands of Chuck Norris.\"\n" +
                "}");
        String randomJoke = norris.randomJoke(url+"/random");
        Assert.assertEquals(randomJoke,"{\n" +
                "    \"categories\": [],\n" +
                "    \"created_at\": \"2020-01-05 13:42:21.795084\",\n" +
                "    \"icon_url\": \"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\n" +
                "    \"id\": \"UuaDu58eTPGgB2pq2DNz3Q\"\n" +
                "    \"updated_at\": \"2020-01-05 13:42:21.795084\"\n" +
                "    \"url\": \"https://api.chucknorris.io/jokes/UuaDu58eTPGgB2pq2DNz3Q\"\n" +
                "    \"value\": \"BB guns are considered nonlethal weapons...except when in the hands of Chuck Norris.\"\n" +
                "}");
    }
    @Test
    public void randomCategoryTest(){
        when(norris.randomCategory(url+"/random?category=food")).thenReturn("{\n" +
                "    \"categories\": [\"food\"],\n" +
                "    \"created_at\": \"2020-01-05 13:42:19.576875\",\n" +
                "    \"icon_url\": \"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\n" +
                "    \"id\": \"ojw-faz_tbglq0q4sgwt8w\"\n" +
                "    \"updated_at\": \"2020-01-05 13:42:19.576875\"\n" +
                "    \"url\": \"https://api.chucknorris.io/jokes/ojw-faz_tbglq0q4sgwt8w\"\n" +
                "    \"value\": \"Chuck Norris doesn't churn butter. He roundhouse kicks the cows and the butter comes straight out.\"\n" +
                "}");
        String randomCategory = norris.randomCategory(url+"/random?category=food");
        Assert.assertEquals(randomCategory,"{\n" +
                "    \"categories\": [\"food\"],\n" +
                "    \"created_at\": \"2020-01-05 13:42:19.576875\",\n" +
                "    \"icon_url\": \"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\n" +
                "    \"id\": \"ojw-faz_tbglq0q4sgwt8w\"\n" +
                "    \"updated_at\": \"2020-01-05 13:42:19.576875\"\n" +
                "    \"url\": \"https://api.chucknorris.io/jokes/ojw-faz_tbglq0q4sgwt8w\"\n" +
                "    \"value\": \"Chuck Norris doesn't churn butter. He roundhouse kicks the cows and the butter comes straight out.\"\n" +
                "}");
    }
   @Test
    public void categoryTest(){
        when(norris.category(url+"/categories")).thenReturn("[\n" +
                "    \"animal\",\n" +
                "    \"career\",\n" +
                "    \"celebrity\",\n" +
                "    \"dev\",\n" +
                "    \"explicit\",\n" +
                "    \"fashion\",\n" +
                "    \"food\",\n" +
                "    \"history\",\n" +
                "    \"money\",\n" +
                "    \"movie\",\n" +
                "    \"music\",\n" +
                "    \"political\",\n" +
                "    \"religion\",\n" +
                "    \"science\",\n" +
                "    \"sport\",\n" +
                "    \"travel\",\n" +
                "}");
        String category = norris.category(url+"/categories");
        Assert.assertEquals(category,"[\n" +
                "    \"animal\",\n" +
                "    \"career\",\n" +
                "    \"celebrity\",\n" +
                "    \"dev\",\n" +
                "    \"explicit\",\n" +
                "    \"fashion\",\n" +
                "    \"food\",\n" +
                "    \"history\",\n" +
                "    \"money\",\n" +
                "    \"movie\",\n" +
                "    \"music\",\n" +
                "    \"political\",\n" +
                "    \"religion\",\n" +
                "    \"science\",\n" +
                "    \"sport\",\n" +
                "    \"travel\",\n" +
                "}");
    }
   @Test
    public void textSearchTest(){
        when(norris.textSearch(url+"/search?query=penguin")).thenReturn("{\n" +
                "    \"total\": 2,\n" +
                "    \"result\": \n" +
                "    [{\n" +
                "    \"categories\": [],\n" +
                "    \"created_at\": \"2020-01-05 13:42:21.179347\",\n" +
                "    \"icon_url\": \"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\n" +
                "    \"id\": \"yoYTppVNTyq1qn-rLoM9hw\"\n" +
                "    \"updated_at\": \"2020-01-05 13:42:21.179347\"\n" +
                "    \"url\": \"https://api.chucknorris.io/jokes/yoYTppVNTyq1qn-rLoM9hw\"\n" +
                "    \"value\": \"Chuck Norris is the reason the penguins live in Antarctica.\"\n" +
                "    },{\n" +
                "    \"categories\": [],\n" +
                "    \"created_at\": \"2020-01-05 13:42:25.628594\",\n" +
                "    \"icon_url\": \"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\n" +
                "    \"id\": \"1E1go-APTEqKG9WgbsV-xg\"\n" +
                "    \"updated_at\": \"2020-01-05 13:42:25.628594\"\n" +
                "    \"url\": \"https://api.chucknorris.io/jokes/1E1go-APTEqKG9WgbsV-xg\"\n" +
                "    \"value\": \"A penguin once made fun of Chuck Norris. In revenge, he set Antarctica on fire. It was successful.\"\n" +
                "}]}");
        String textSearch = norris.textSearch(url+"/search?query=penguin");
        Assert.assertEquals(textSearch,"{\n" +
                "    \"total\": 2,\n" +
                "    \"result\": \n" +
                "    [{\n" +
                "    \"categories\": [],\n" +
                "    \"created_at\": \"2020-01-05 13:42:21.179347\",\n" +
                "    \"icon_url\": \"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\n" +
                "    \"id\": \"yoYTppVNTyq1qn-rLoM9hw\"\n" +
                "    \"updated_at\": \"2020-01-05 13:42:21.179347\"\n" +
                "    \"url\": \"https://api.chucknorris.io/jokes/yoYTppVNTyq1qn-rLoM9hw\"\n" +
                "    \"value\": \"Chuck Norris is the reason the penguins live in Antarctica.\"\n" +
                "    },{\n" +
                "    \"categories\": [],\n" +
                "    \"created_at\": \"2020-01-05 13:42:25.628594\",\n" +
                "    \"icon_url\": \"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\n" +
                "    \"id\": \"1E1go-APTEqKG9WgbsV-xg\"\n" +
                "    \"updated_at\": \"2020-01-05 13:42:25.628594\"\n" +
                "    \"url\": \"https://api.chucknorris.io/jokes/1E1go-APTEqKG9WgbsV-xg\"\n" +
                "    \"value\": \"A penguin once made fun of Chuck Norris. In revenge, he set Antarctica on fire. It was successful.\"\n" +
                "}]}");
    }
}