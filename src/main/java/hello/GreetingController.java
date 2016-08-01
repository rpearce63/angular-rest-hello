package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final String NAME = "World";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method=RequestMethod.GET)
    public Greeting greeting(){
    	return greeting(NAME);
    }
    
   @RequestMapping(method=RequestMethod.GET, value="{name}")
    public Greeting greeting(@PathVariable String name) {
	   if("undefined".equals(name)) {name = NAME;}
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}