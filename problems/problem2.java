if (!file.isEmpty()) {

    String fileName = file.getOriginalFilename();

    String successMessage = "File successfully uploaded";
    modelData.put("fileName", fileName);
    modelData.put("uploadMessage", successMessage);
    savefile(file);

    return new ModelAndView("uploadForm", modelData);

}
