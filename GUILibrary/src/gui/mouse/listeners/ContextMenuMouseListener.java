package gui.mouse.listeners;
 
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;
import javax.swing.Action;
import javax.swing.JPopupMenu;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.JTextComponent;

public class ContextMenuMouseListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        ResourceBundle resource = ResourceBundle.getBundle("resources.data");
        String cut = resource.getString("cut");
        String selectAll = resource.getString("selectAll");
        String copy = resource.getString("copy");
        String paste = resource.getString("paste");
        if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
            if (!(e.getSource() instanceof JTextComponent)) {
                return;
            } 
            JTextComponent textComponent = (JTextComponent) e.getSource();
            textComponent.requestFocus();
            boolean enabled = textComponent.isEnabled();
            boolean editable = textComponent.isEditable();
            boolean nonempty = !(textComponent.getText() == null || textComponent.getText().equals(""));
            boolean marked = textComponent.getSelectedText() != null; 
            boolean pasteAvailable =
                    Toolkit.getDefaultToolkit().getSystemClipboard().
                    getContents(null).isDataFlavorSupported(
                    DataFlavor.stringFlavor); 
            JPopupMenu popup = new JPopupMenu(); 
            if (enabled && editable && marked) {
                Action cutAction = textComponent.getActionMap().get(DefaultEditorKit.cutAction);
                if (cutAction == null) {
                    cutAction = textComponent.getActionMap().get("cut");
                }
                if (cutAction != null) {
                    popup.add(cutAction).setText(cut);
                }
            }
            if (enabled && marked) {
                Action copyAction = textComponent.getActionMap().get(DefaultEditorKit.copyAction);
                if (copyAction == null) {
                    copyAction = textComponent.getActionMap().get("copy");
                }
                if (copyAction != null) {
                    popup.add(copyAction).setText(copy);
                }
            }
            if (enabled && editable && pasteAvailable) {
                Action pasteAction = textComponent.getActionMap().get(DefaultEditorKit.pasteAction);
                if (pasteAction == null) {
                    pasteAction = textComponent.getActionMap().get("paste");
                }
                if (pasteAction != null) {
                    popup.add(pasteAction).setText(paste);
                }
            } 
            if (enabled && nonempty) {
                Action selectAllAction = textComponent.getActionMap().get(DefaultEditorKit.selectAllAction);
                if (selectAllAction == null) {
                    selectAllAction = textComponent.getActionMap().get("selectAll");
                }
                if (selectAllAction != null) {
                    if (popup.getComponentCount() > 0) {
                        if (!(popup.getComponent(popup.getComponentCount() - 1) instanceof JPopupMenu.Separator)) {
                            popup.addSeparator();
                        }
                    }
                    popup.add(selectAllAction).setText(selectAll);
                } 
            } 
            if (popup.getComponentCount() > 0) {
                if (popup.getComponent(0) instanceof JPopupMenu.Separator) {
                    popup.remove(0);
                }
                if (popup.getComponent(popup.getComponentCount() - 1) instanceof JPopupMenu.Separator) {
                    popup.remove(popup.getComponentCount() - 1);
                }
                popup.show(e.getComponent(), e.getX(), e.getY() - popup.getSize().height);
            }
        }
    }
}