# ratpack-healthcheck-example
An example of configuring healthchecks for a [Ratpack](https://www.ratpack.io) service.

This example starts a service containing two components, foo and bar, which each have their own Ratpack healthchecks implemented. You are able to
control the health of the components and see the effect on their respective healthcheck endpoints.

## Running the Example
1. Start the example by running the following Gradle command:

        $ ./gradlew run 

2. Once the application has started check the health of all healthchecks using the following command:

        $ curl "http://localhost:5050/health"
        
    You should see the following response:
    
        bar : HEALTHY [The bar endpoint is currently healthy]
        foo : HEALTHY [The foo endpoint is currently healthy]

3. Set the foo component's state to unhealthy using the following command:

        $ curl -X "POST" "http://localhost:5050/foo" \
             -H 'Content-Type: application/x-www-form-urlencoded; charset=utf-8' \
             --data-urlencode "healthy=false"

4. Now re-run the all healthchecks endpoint and validate that foo is unhealthy:

        $ curl "http://localhost:5050/health"
        
    You should see the following response:
    
        bar : HEALTHY [The bar endpoint is currently healthy]
        foo : UNHEALTHY [The foo endpoint is currently unhealthy]
        
5. You can run the individual healthchecks using the following commands:

    Run the Foo Healthcheck:
    
        $ curl "http://localhost:5050/health/foo"
    
    Run the Bar Healthcheck:
    
        $ curl "http://localhost:5050/health/bar"

## Bugs and Feedback
For bugs, questions, and discussions please use the [Github Issues](https://github.com/gregwhitaker/ratpack-healthcheck-example/issues).

## License
MIT License

Copyright (c) 2018 Greg Whitaker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
