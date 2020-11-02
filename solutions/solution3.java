if (!file.isEmpty()) {

    String fileName = file.getOriginalFilename();

    if(fileName.contains("\0")){
        fileName = fileName.substring(0, fileName.indexOf('.')) + fileName.substring(fileName.indexOf('\0') + 1, fileName.length());
    }

    String successMessage = "File successfully uploaded";
    modelData.put("fileName", fileName);
    modelData.put("uploadMessage", successMessage);
    savefile(file);

    return new ModelAndView("uploadForm", modelData);

}
