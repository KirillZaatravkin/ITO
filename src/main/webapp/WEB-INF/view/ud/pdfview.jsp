

    <%
        File pdfFile = new File("E:\\1.pdf");
        byte[] pdfByteArray = FileUtils.readFileToByteArray(pdfFile);
        response.setContentType("application/pdf");
        response.getOutputStream().write(pdfByteArray);
        response.getOutputStream().flush();
    %>
