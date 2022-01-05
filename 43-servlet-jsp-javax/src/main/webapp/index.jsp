<html>

<body>
    <h1>Counter Example</h1>

    <p>First visit:
        <% 
        String firstVisit="never";

        if (request.getCookies() != null) {
            for(int i = 0; i < request.getCookies().length; i++) {
                String name = request.getCookies()[i].getName();

                if(name.equals("firstVisit")) {
                    firstVisit = request.getCookies()[i].getValue();
                }
            }
        }

        out.print(firstVisit);
        %>
    </p>

    <p>Count: <% 
        out.print(request.getSession().getAttribute("count") == null ? 0 : request.getSession().getAttribute("count")); 
    %></p>

    <p><a href="/ServletJspDemo/counter.svl">Count me!</a></p>
</body>

</html>