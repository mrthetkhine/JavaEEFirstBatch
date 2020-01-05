import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LambdaTest {
	public static void main(String[]args)
	{
		List<Integer> arr = Arrays.asList(1,2,4,5,7);
		 
		Optional<Integer> square = arr.stream()
								.map( ele-> ele * ele)
								.filter( ele-> ele % 2 == 0)
								.reduce( (a,b) -> a+b);
								//.collect(Collectors.toList());
		System.out.println("Square "+ square.get());
		
	}
}
