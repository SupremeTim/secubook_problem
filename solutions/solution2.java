if (!file.isEmpty()) {

    String fileName = file.getOriginalFilename();

    if(fileName.endsWith(".JPG")){
        String successMessage = "File successfully uploaded";

        modelData.put("fileName", fileName);
        modelData.put("uploadMessage", successMessage);
        savefile(file);

        return new ModelAndView("uploadForm", modelData);
    }
    else{
        String failureMessage = "File couldn't be uploaded.";

        modelData.put("fileName", fileName);
        modelData.put("uploadMessage", failureMessage);

        return new ModelAndView("uploadForm", modelData);

    }

}
