package ma.enset.sdia_mini_project.presentation.models;

import ma.enset.sdia_mini_project.presentation.views.ViewFactory;

public class Model {
    private static Model model;
    private ViewFactory viewFactory;

    public Model() {
        this.viewFactory = new ViewFactory();
    }

    public static synchronized Model getInstance(){
        if(model == null ){
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }
}
