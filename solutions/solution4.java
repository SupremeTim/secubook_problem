if (!file.isEmpty()) {

    String fileName = file.getOriginalFilename();

    if(fileName.matches("^\\S+.(?i)(php)+[0-9]")){
        String failureMessage = "File couldn't be uploaded.";
        modelData.put("uploadMessage", failureMessage);
        modelData.put("fileName", file.getOriginalFilename());

        return new ModelAndView("uploadForm", modelData);
    }


    String successMessage = "File successfully uploaded";
    modelData.put("fileName", fileName);
    modelData.put("uploadMessage", successMessage);
    savefile(file);

    return new ModelAndView("uploadForm", modelData);

}
