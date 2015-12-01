package app.views
import com.vaadin.annotations.DesignRoot
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.server.ExternalResource
import com.vaadin.ui.*
import com.vaadin.ui.declarative.Design
import org.vaadin.grails.navigator.Navigation

@DesignRoot
class MainView extends VerticalLayout implements View {

    VerticalLayout menuContent;
    Panel equalPanel;
    Button logout;

    MainView() {
        Design.read this

        def button = {String title, String menuitem -> new Button(title,
                {Navigation.navigateTo(fragment:"main/$menuitem")} as Button.ClickListener)}

        menuContent.addComponent button("Pig", "pig")
        menuContent.addComponent button("Cat", "cat")
        menuContent.addComponent button("Dog", "dog")
        menuContent.addComponent button("Reindeer", "reindeer");
        menuContent.addComponent button("Penguin", "penguin");
        menuContent.addComponent button("Sheep", "sheep");

        // Allow going back to the start
        logout.addClickListener { Navigation.navigateTo(fragment:"") }
    }

    @DesignRoot
    class AnimalViewer extends VerticalLayout {
        Label watching;
        Embedded pic;
        Label back;

        AnimalViewer(String animal) {
            Design.read this

//            AssetProcessorService assetService = Grails.get AssetProcessorService
//            DefaultLinkGenerator defLinkGenerator = Grails.get DefaultLinkGenerator
//
//            String asset=assetService.asset(file:"$animal-128px.png", defLinkGenerator)
            watching.value="You are currently watching a $animal"
            pic.source = new ExternalResource("/$animal-128px.png")
            back.value="and $animal is watching you back"
        }
    }

    @Override
    void enter(ViewChangeListener.ViewChangeEvent event) {
        def parameter = event.viewName.tokenize("/").last()
        equalPanel.content = parameter ?
                new AnimalViewer(parameter) : new Label("Nothing to see here, just pass along.")
    }
}