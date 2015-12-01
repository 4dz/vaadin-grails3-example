package app.views

import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.ui.Alignment
import com.vaadin.ui.Button
import com.vaadin.ui.Notification
import com.vaadin.ui.VerticalLayout
import org.vaadin.grails.navigator.Navigation

class StartView extends VerticalLayout implements View {

    StartView() {
        setSizeFull()
        margin = true

        new Button().with { button->
            caption="Go to Main View"
            addClickListener { Navigation.navigateTo(fragment: "main") }

            addComponent button
            setComponentAlignment button, Alignment.MIDDLE_CENTER
        }
    }

    @Override
    void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show "Welcome to the Animal Farm"
    }
}
