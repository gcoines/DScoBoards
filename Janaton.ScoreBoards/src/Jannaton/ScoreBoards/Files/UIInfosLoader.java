/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Files;

import Jannaton.ScoreBoards.Interfaces.EnumScoreBoardPaneType;
import Jannaton.ScoreBoards.Interfaces.EnumUIInfoPropertyType;
import Jannaton.ScoreBoards.Interfaces.IBackgroundInfo;
import Jannaton.ScoreBoards.Interfaces.IButtonInfo;
import Jannaton.ScoreBoards.Interfaces.IButtonsPanelInfo;
import Jannaton.ScoreBoards.Interfaces.IColumnInfo;
import Jannaton.ScoreBoards.Interfaces.IComponentInfo;
import Jannaton.ScoreBoards.Interfaces.IComponentsInfo;
import Jannaton.ScoreBoards.Interfaces.IConfigurationInfo;
import Jannaton.ScoreBoards.Interfaces.IConfigurationsInfo;
import Jannaton.ScoreBoards.Interfaces.IControlPanelInfo;
import Jannaton.ScoreBoards.Interfaces.IImageInfo;
import Jannaton.ScoreBoards.Interfaces.ILayoutInfo;
import Jannaton.ScoreBoards.Interfaces.IMenuInfo;
import Jannaton.ScoreBoards.Interfaces.IRowInfo;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardInfo;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardUIInfo;
import Jannaton.ScoreBoards.Interfaces.IStyleInfo;
import Jannaton.ScoreBoards.Interfaces.IStylesInfo;
import Jannaton.ScoreBoards.ScoreBoardsUIInfoManager;
import Jannaton.Utils.Xml.XmlManager;
import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author german
 */
public class UIInfosLoader {

    private static UIInfosLoader instance;

    private UIInfosLoader() {
    }

    public static UIInfosLoader getInstance() {
        if (instance == null) {
            instance = new UIInfosLoader();
        }

        return instance;
    }

    public IScoreBoardUIInfo convert(Node source) {
        IScoreBoardUIInfo uiInfo = ScoreBoardsUIInfoManager.getInstance().createScoreBoardUIInfo();

        String id = XmlManager.getAttributeByNameValue(source, "id");
        uiInfo.setId(id);

        this.fillInfoProperties(source, uiInfo);

        return uiInfo;
    }

    private void fillInfoProperties(Node source, Object target) {
        NodeList infoTags = XmlManager.getChildElementNodes(source);
        int lenght = infoTags.getLength();
        for (int i = 0; i < lenght; i++) {
            Node infoTag = infoTags.item(i);
            EnumUIInfoPropertyType type = this.obtainPropertyType(infoTag);
            if (type != null) {
                switch (type) {
                    case LAYOUT:
                        this.fillLayoutInfo(infoTag, target);
                        break;
                    case COMPONENTS:
                        this.fillComponentsInfo(infoTag, target);
                        break;
                    case STYLES:
                        this.fillStylesInfo(infoTag, target);
                        break;
                    case MENU:
                        this.fillMenuInfo(infoTag, target);
                        break;
                    case CONTROL_PANEL:
                        this.fillControlPanelInfo(infoTag, target);
                        break;
                }
            }
        }
    }

    //Layout functions
    private void fillLayoutInfo(Node layoutTag, Object target) {
        ILayoutInfo layoutInfo = ScoreBoardsUIInfoManager.getInstance().createLayoutInfo();

        NodeList layoutChilds = XmlManager.getChildElementNodes(layoutTag);
        int lenght = layoutChilds.getLength();
        for (int i = 0; i < lenght; i++) {
            Node child = layoutChilds.item(i);
            EnumUIInfoPropertyType type = this.obtainPropertyType(child);
            if (type != null) {
                switch (type) {
                    case COLUMNS:
                        this.fillColumnsInfo(child, layoutInfo);
                        break;
                    case ROWS:
                        this.fillRowsInfo(child, layoutInfo);
                        break;
                }
            }
        }

        ((IScoreBoardUIInfo) target).setLayoutInfo(layoutInfo);
    }

    private void fillColumnsInfo(Node columnsTag, Object target) {
        ArrayList<IColumnInfo> columnsInfo = new ArrayList<IColumnInfo>();

        NodeList columnTags = XmlManager.getChildElementNodes(columnsTag);
        int lenght = columnTags.getLength();
        for (int i = 0; i < lenght; i++) {
            Node columnTag = columnTags.item(i);
            columnsInfo.add(this.fillColumnInfo(columnTag));
        }

        ((ILayoutInfo) target).setColumnsInfo(columnsInfo);
    }

    private IColumnInfo fillColumnInfo(Node columnTag) {
        IColumnInfo target = ScoreBoardsUIInfoManager.getInstance().createColumnInfo();

        //TODO implement further atributtes
        String alignment = XmlManager.getAttributeByNameValue(columnTag, "hAlignment");
        if (alignment != null) {
            if (alignment.equals("left")) {
                target.setAlignment(IColumnInfo.Alignment.LEFT);
            }
            if (alignment.equals("center")) {
                target.setAlignment(IColumnInfo.Alignment.CENTER);
            }
            if (alignment.equals("right")) {
                target.setAlignment(IColumnInfo.Alignment.RIGHT);
            }
        }

        return target;
    }

    private void fillRowsInfo(Node rowsTag, Object target) {
        ArrayList<IRowInfo> rowsInfo = new ArrayList<IRowInfo>();

        NodeList rowTags = XmlManager.getChildElementNodes(rowsTag);
        int lenght = rowTags.getLength();
        for (int i = 0; i < lenght; i++) {
            Node rowTag = rowTags.item(i);
            rowsInfo.add(this.fillRowInfo(rowTag));
        }

        ((ILayoutInfo) target).setRowsInfo(rowsInfo);
    }

    private IRowInfo fillRowInfo(Node columnTag) {
        IRowInfo target = ScoreBoardsUIInfoManager.getInstance().createRowInfo();

        //TODO implement further atributtes
        String alignment = XmlManager.getAttributeByNameValue(columnTag, "vAlignment");
        if (alignment != null) {
            if (alignment.equals("top")) {
                target.setAlignment(IRowInfo.Alignment.TOP);
            }
            if (alignment.equals("middle")) {
                target.setAlignment(IRowInfo.Alignment.MIDDLE);
            }
            if (alignment.equals("bottom")) {
                target.setAlignment(IRowInfo.Alignment.BOTTOM);
            }
        }

        return target;
    }

    //Components functions
    private void fillComponentsInfo(Node componentsTag, Object target) {
        IComponentsInfo componentsInfo = ScoreBoardsUIInfoManager.getInstance().createComponentsInfo();

        ArrayList<IComponentInfo> componentInfos = new ArrayList<IComponentInfo>();

        NodeList componentsChilds = XmlManager.getChildElementNodes(componentsTag);
        int lenght = componentsChilds.getLength();
        for (int i = 0; i < lenght; i++) {
            Node component = componentsChilds.item(i);
            EnumScoreBoardPaneType type = this.obtainComponentType(component);
            if (type != null) {
                componentInfos.add(this.fillComponentInfo(component, type));
            }
        }

        if (componentInfos.size() > 0) {
            componentsInfo.setComponentInfos(componentInfos);
        }

        ((IScoreBoardUIInfo) target).setComponentsInfo(componentsInfo);
    }

    private IComponentInfo fillComponentInfo(Node component, EnumScoreBoardPaneType type) {
        IComponentInfo target = ScoreBoardsUIInfoManager.getInstance().createComponentInfo();

        //TODO implement further atributtes
        String id = XmlManager.getAttributeByNameValue(component, "id");
        String colIndex = XmlManager.getAttributeByNameValue(component, "colIndex");
        String rowIndex = XmlManager.getAttributeByNameValue(component, "rowIndex");
        String colSpan = XmlManager.getAttributeByNameValue(component, "colSpan");
        String rowSpan = XmlManager.getAttributeByNameValue(component, "rowSpan");
        String style = XmlManager.getAttributeByNameValue(component, "style");
        String fileName = XmlManager.getAttributeByNameValue(component, "fileName");
        String text = XmlManager.getAttributeByNameValue(component, "text");

        target.setType(type);

        if (id != null) {
            target.setId(id);
        }

        if (colIndex != null) {
            try {
                int index = Integer.parseInt(colIndex);
                target.setColumnIndex(index);
            } catch (Exception e) {
                //TODO report error
            }
        }

        if (rowIndex != null) {
            try {
                int index = Integer.parseInt(rowIndex);
                target.setRowIndex(index);
            } catch (Exception e) {
                //TODO report error
            }
        }

        if (colSpan != null) {
            try {
                int span = Integer.parseInt(colSpan);
                target.setColumnSpan(span);
            } catch (Exception e) {
                //TODO report error
            }
        }

        if (rowSpan != null) {
            try {
                int span = Integer.parseInt(rowSpan);
                target.setRowSpan(span);
            } catch (Exception e) {
                //TODO report error
            }
        }

        if (style != null) {
            target.setStyle(style);
        }

        if (fileName != null) {
            target.setFileName(fileName);
        }

        if (text != null) {
            target.setText(text);
        }

        return target;
    }

    //Styles functions
    private void fillStylesInfo(Node stylesTag, Object target) {
        IStylesInfo stylesInfo = ScoreBoardsUIInfoManager.getInstance().createStylesInfo();

        ArrayList<IScoreBoardInfo> scoreboardStyleInfos = new ArrayList<IScoreBoardInfo>();
        ArrayList<IStyleInfo> styleInfos = new ArrayList<IStyleInfo>();

        NodeList stylesChilds = XmlManager.getChildElementNodes(stylesTag);
        int lenght = stylesChilds.getLength();
        for (int i = 0; i < lenght; i++) {
            Node style = stylesChilds.item(i);
            EnumUIInfoPropertyType type = this.obtainPropertyType(style);
            //TODO be care with null's adding!
            if (type == EnumUIInfoPropertyType.STYLE) {
                styleInfos.add(this.fillStyleInfo(style));
            } else if (type == EnumUIInfoPropertyType.BACKGROUND) {
                scoreboardStyleInfos.add(this.fillScoreBoardStyleInfo(style, type));
            }
        }

        if (styleInfos.size() > 0) {
            stylesInfo.setStylesInfo(styleInfos);
        }

        if (scoreboardStyleInfos.size() > 0) {
            stylesInfo.setScoreBoardStylesInfo(scoreboardStyleInfos);
        }

        ((IScoreBoardUIInfo) target).setStyleInfo(stylesInfo);
    }

    private IStyleInfo fillStyleInfo(Node styleTag) {
        IStyleInfo target = ScoreBoardsUIInfoManager.getInstance().createStyleInfo();

        //TODO implement further atributtes


        String id = XmlManager.getAttributeByNameValue(styleTag, "id");
        String fontSize = XmlManager.getAttributeByNameValue(styleTag, "fontSize");
        String color = XmlManager.getAttributeByNameValue(styleTag, "color");

        if (id != null) {
            target.setId(id);
        }

        if (fontSize != null) {
            target.setFontSize(fontSize);
        }

        if (color != null) {
            target.setColor(color);
        }

        return target;
    }

    private IScoreBoardInfo fillScoreBoardStyleInfo(Node styleTag,
            EnumUIInfoPropertyType type) {
        //TODO implement rest of cases
        switch (type) {
            case BACKGROUND:
                return this.fillBackgroundInfo(styleTag);
        }

        return null;
    }

    private IBackgroundInfo fillBackgroundInfo(Node background) {
        IBackgroundInfo target = ScoreBoardsUIInfoManager.getInstance().createBackgroundInfo();

        NodeList children = XmlManager.getChildElementNodes(background);
        if (children != null) {
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                switch (this.obtainPropertyType(child)) {
                    //TODO implement rest of cases
                    case IMAGE:
                        this.fillBackGroundImage(target, child);
                        break;
                }
            }
        }
        return target;
    }

    private void fillBackGroundImage(IBackgroundInfo target, Node imageNode) {
        target.setImageInfo(this.fillImage(imageNode));
    }

    //Menu functions
    private void fillMenuInfo(Node menuTag, Object target) {
        IMenuInfo menuInfo = ScoreBoardsUIInfoManager.getInstance().createMenuInfo();
//
        ArrayList<IScoreBoardInfo> menuInfos = new ArrayList<IScoreBoardInfo>();
        IConfigurationsInfo configurationsInfos = ScoreBoardsUIInfoManager.getInstance().createConfigurationsInfo();
//
        NodeList menuChilds = XmlManager.getChildElementNodes(menuTag);
        int lenght = menuChilds.getLength();
        for (int i = 0; i < lenght; i++) {
            Node menu = menuChilds.item(i);
            EnumUIInfoPropertyType type = this.obtainPropertyType(menu);
            //TODO be care with null's adding!
            //TODO implement next cases
            if (type == EnumUIInfoPropertyType.CONFIGURATIONS) {
                this.fillConfigurationsInfo(configurationsInfos, menu);
            } else if (type == EnumUIInfoPropertyType.BUTTON) {
                menuInfos.add(this.fillButtonInfo(menu));
            }
        }
        //TODO becare, have to be null if no config info exists
        menuInfo.setConfigurationInfo(configurationsInfos);

        if (menuInfos.size() > 0) {
            menuInfo.setScoreBoardInfo(menuInfos);
        }
//
        ((IScoreBoardUIInfo) target).setMenuInfo(menuInfo);
    }

    private void fillConfigurationsInfo(IConfigurationsInfo target, Node configurationsNode) {
        ArrayList<IConfigurationInfo> configurationInfos = new ArrayList<IConfigurationInfo>();

        NodeList configurationsChilds = XmlManager.getChildElementNodes(configurationsNode);
        //TODO be care with null addings
        for (int i = 0; i < configurationsChilds.getLength(); i++) {
            Node configuration = configurationsChilds.item(i);
            configurationInfos.add(this.fillConfigurationInfo(configuration));
        }

        target.setConfigurationInfos(configurationInfos);
    }

    private IButtonInfo fillButtonInfo(Node buttonNode) {
        IButtonInfo buttonInfo = ScoreBoardsUIInfoManager.getInstance().createButtonInfo();

        NodeList menuChilds = XmlManager.getChildElementNodes(buttonNode);
        int lenght = menuChilds.getLength();
        for (int i = 0; i < lenght; i++) {
            Node child = menuChilds.item(i);
            EnumUIInfoPropertyType type = this.obtainPropertyType(child);
            //TODO be care with null's adding!
            //TODO implement next cases
            if (type == EnumUIInfoPropertyType.IMAGE) {
                buttonInfo.setImageInfo(this.fillImage(child));
            }
        }

        return buttonInfo;
    }

    private IConfigurationInfo fillConfigurationInfo(Node configurationTag) {
        IConfigurationInfo target = ScoreBoardsUIInfoManager.getInstance().createConfigurationInfo();

        //TODO implement further atributtes
        String id = XmlManager.getAttributeByNameValue(configurationTag, "id");
        String fieldType = XmlManager.getAttributeByNameValue(configurationTag, "fieldType");
        String fieldName = XmlManager.getAttributeByNameValue(configurationTag, "fieldName");
        String minValue = XmlManager.getAttributeByNameValue(configurationTag, "minValue");
        String maxValue = XmlManager.getAttributeByNameValue(configurationTag, "maxValue");
        String defaultValue = XmlManager.getAttributeByNameValue(configurationTag, "default");

        if (id != null) {
            target.setId(id);
        }

        if (fieldType != null) {
            target.setFieldType(fieldType);
        }

        if (fieldName != null) {
            target.setFieldName(fieldName);
        }

        if (minValue != null) {
            target.setMinValue(minValue);
        }

        if (maxValue != null) {
            target.setMaxValue(maxValue);
        }

        if (defaultValue != null) {
            target.setDefault(defaultValue);
        }

        return target;
    }

    //ControlPanel functions
    private void fillControlPanelInfo(Node menuTag, Object target) {
        IControlPanelInfo controlPanelInfo = ScoreBoardsUIInfoManager.getInstance().createControlPanelInfo();

        this.fillControlPanelProperties(menuTag, controlPanelInfo);

        ((IScoreBoardUIInfo) target).setControlPanelInfo(controlPanelInfo);
    }

    private void fillControlPanelProperties(Node source, IControlPanelInfo target) {
        NodeList infoTags = XmlManager.getChildElementNodes(source);
        int lenght = infoTags.getLength();
        for (int i = 0; i < lenght; i++) {
            Node infoTag = infoTags.item(i);
            EnumUIInfoPropertyType type = this.obtainPropertyType(infoTag);
            if (type != null) {
                switch (type) {
                    case LAYOUT:
                        this.fillLayoutInfo(infoTag, target);
                        break;
                    case COMPONENTS:
                        this.fillComponentsInfo(infoTag, target);
                        break;
                }
            }
        }
    }

    private void fillLayoutInfo(Node layoutTag, IControlPanelInfo target) {
        ILayoutInfo layoutInfo = ScoreBoardsUIInfoManager.getInstance().createLayoutInfo();

        NodeList layoutChilds = XmlManager.getChildElementNodes(layoutTag);
        int lenght = layoutChilds.getLength();
        for (int i = 0; i < lenght; i++) {
            Node child = layoutChilds.item(i);
            EnumUIInfoPropertyType type = this.obtainPropertyType(child);
            if (type != null) {
                switch (type) {
                    case COLUMNS:
                        this.fillColumnsInfo(child, layoutInfo);
                        break;
                    case ROWS:
                        this.fillRowsInfo(child, layoutInfo);
                        break;
                }
            }
        }

        ((IControlPanelInfo) target).setLayoutInfo(layoutInfo);
    }

    private void fillComponentsInfo(Node componentsTag, IControlPanelInfo target) {
        IComponentsInfo componentsInfo = ScoreBoardsUIInfoManager.getInstance().createComponentsInfo();

        ArrayList<IComponentInfo> componentInfos = new ArrayList<IComponentInfo>();

        NodeList componentsChilds = XmlManager.getChildElementNodes(componentsTag);
        int lenght = componentsChilds.getLength();
        for (int i = 0; i < lenght; i++) {
            Node component = componentsChilds.item(i);
            EnumScoreBoardPaneType type = this.obtainComponentType(component);
            if (type != null) {
                //TODO check fo BUTTONS_PANEL type 
                if (!type.equals(EnumScoreBoardPaneType.BUTTONS_PANEL)) {
                    IComponentInfo componentInfo = this.fillComponentInfo(component, type);

                    componentInfos.add(componentInfo);

                } else {
                    IButtonsPanelInfo buttonsPanelInfo = this.fillButtonsPanelInfo(component, type);
                    this.fillButtonPanelChild(component, buttonsPanelInfo);
                    componentInfos.add((IComponentInfo) buttonsPanelInfo);
                }

            }
        }

        if (componentInfos.size() > 0) {
            componentsInfo.setComponentInfos(componentInfos);
        }

        ((IControlPanelInfo) target).setComponentsInfo(componentsInfo);
    }

    private IButtonsPanelInfo fillButtonsPanelInfo(Node component, EnumScoreBoardPaneType type) {
        IButtonsPanelInfo target = ScoreBoardsUIInfoManager.getInstance().createButtonsPanelInfo();

        //TODO implement further atributtes
        String id = XmlManager.getAttributeByNameValue(component, "id");
        String colIndex = XmlManager.getAttributeByNameValue(component, "colIndex");
        String rowIndex = XmlManager.getAttributeByNameValue(component, "rowIndex");
        String colSpan = XmlManager.getAttributeByNameValue(component, "colSpan");
        String rowSpan = XmlManager.getAttributeByNameValue(component, "rowSpan");
        String style = XmlManager.getAttributeByNameValue(component, "style");
        String fileName = XmlManager.getAttributeByNameValue(component, "fileName");
        String text = XmlManager.getAttributeByNameValue(component, "text");

        target.setType(type);

        if (id != null) {
            target.setId(id);
        }

        if (colIndex != null) {
            try {
                int index = Integer.parseInt(colIndex);
                target.setColumnIndex(index);
            } catch (Exception e) {
                //TODO report error
            }
        }

        if (rowIndex != null) {
            try {
                int index = Integer.parseInt(rowIndex);
                target.setRowIndex(index);
            } catch (Exception e) {
                //TODO report error
            }
        }

        if (colSpan != null) {
            try {
                int span = Integer.parseInt(colSpan);
                target.setColumnSpan(span);
            } catch (Exception e) {
                //TODO report error
            }
        }

        if (rowSpan != null) {
            try {
                int span = Integer.parseInt(rowSpan);
                target.setRowSpan(span);
            } catch (Exception e) {
                //TODO report error
            }
        }

        if (style != null) {
            target.setStyle(style);
        }

        if (fileName != null) {
            target.setFileName(fileName);
        }

        if (text != null) {
            target.setText(text);
        }

        return target;
    }

    private void fillButtonPanelChild(Node source, IButtonsPanelInfo target) {
        NodeList infoTags = XmlManager.getChildElementNodes(source);
        int lenght = infoTags.getLength();
        for (int i = 0; i < lenght; i++) {
            Node infoTag = infoTags.item(i);
            EnumUIInfoPropertyType type = this.obtainPropertyType(infoTag);
            if (type != null) {
                switch (type) {
                    case LAYOUT:
                        this.fillLayoutInfo(infoTag, target);
                        break;
                    case COMPONENTS:
                        this.fillComponentsInfo(infoTag, target);
                        break;
                }
            }
        }
    }

    private void fillLayoutInfo(Node layoutTag, IButtonsPanelInfo target) {
        ILayoutInfo layoutInfo = ScoreBoardsUIInfoManager.getInstance().createLayoutInfo();

        NodeList layoutChilds = XmlManager.getChildElementNodes(layoutTag);
        int lenght = layoutChilds.getLength();
        for (int i = 0; i < lenght; i++) {
            Node child = layoutChilds.item(i);
            EnumUIInfoPropertyType type = this.obtainPropertyType(child);
            if (type != null) {
                switch (type) {
                    case COLUMNS:
                        this.fillColumnsInfo(child, layoutInfo);
                        break;
                    case ROWS:
                        this.fillRowsInfo(child, layoutInfo);
                        break;
                }
            }
        }

        ((IButtonsPanelInfo) target).setLayoutInfo(layoutInfo);
    }

    private void fillComponentsInfo(Node componentsTag, IButtonsPanelInfo target) {
        IComponentsInfo componentsInfo = ScoreBoardsUIInfoManager.getInstance().createComponentsInfo();

        ArrayList<IComponentInfo> componentInfos = new ArrayList<IComponentInfo>();

        NodeList componentsChilds = XmlManager.getChildElementNodes(componentsTag);
        int lenght = componentsChilds.getLength();
        for (int i = 0; i < lenght; i++) {
            Node component = componentsChilds.item(i);
            EnumScoreBoardPaneType type = this.obtainComponentType(component);
            if (type != null) {
                //TODO check fo BUTTONS_PANEL type 
                IComponentInfo componentInfo = this.fillComponentInfo(component, type);
                componentInfos.add(componentInfo);
            }
        }

        if (componentInfos.size() > 0) {
            componentsInfo.setComponentInfos(componentInfos);
        }

        ((IButtonsPanelInfo) target).setComponentsInfo(componentsInfo);
    }
    //Helper functions    

    private IImageInfo fillImage(Node imageNode) {
        IImageInfo image = ScoreBoardsUIInfoManager.getInstance().createImageInfo();

        String fileName = XmlManager.getAttributeByNameValue(imageNode, "fileName");
        //TODO be care if fileName is empty
        if (fileName != null) {
            image.setImageFileName(fileName);
        }
        return image;
    }

    private EnumUIInfoPropertyType obtainPropertyType(Node propertyTag) {
        String type = propertyTag.getNodeName();

        if (type.equals("layout")) {
            return EnumUIInfoPropertyType.LAYOUT;
        }

        if (type.equals("columns")) {
            return EnumUIInfoPropertyType.COLUMNS;
        }

        if (type.equals("rows")) {
            return EnumUIInfoPropertyType.ROWS;
        }

        if (type.equals("components")) {
            return EnumUIInfoPropertyType.COMPONENTS;
        }

        if (type.equals("styles")) {
            return EnumUIInfoPropertyType.STYLES;
        }

        if (type.equals("style")) {
            return EnumUIInfoPropertyType.STYLE;
        }

        if (type.equals("background")) {
            return EnumUIInfoPropertyType.BACKGROUND;
        }

        if (type.equals("image")) {
            return EnumUIInfoPropertyType.IMAGE;
        }

        if (type.equals("menu")) {
            return EnumUIInfoPropertyType.MENU;
        }

        if (type.equals("button")) {
            return EnumUIInfoPropertyType.BUTTON;
        }

        if (type.equals("configurations")) {
            return EnumUIInfoPropertyType.CONFIGURATIONS;
        }

        if (type.equals("configuration")) {
            return EnumUIInfoPropertyType.CONFIGURATION;
        }

        if (type.equals("controlPanel")) {
            return EnumUIInfoPropertyType.CONTROL_PANEL;
        }

        if (type.equals("image")) {
            return EnumUIInfoPropertyType.IMAGE;
        }
        //TODO implement rest of the cases

        return null;
    }

    private EnumScoreBoardPaneType obtainComponentType(Node propertyTag) {
        String type = propertyTag.getNodeName();

        if (type.equals("counter")) {
            return EnumScoreBoardPaneType.COUNTER;
        }

        if (type.equals("timer")) {
            return EnumScoreBoardPaneType.TIMER;
        }

        if (type.equals("chronometer")) {
            return EnumScoreBoardPaneType.CHRONOMETER;
        }

        if (type.equals("text")) {
            return EnumScoreBoardPaneType.TEXT;
        }

        if (type.equals("buttonsPane")) {
            return EnumScoreBoardPaneType.BUTTONS_PANEL;
        }

        if (type.equals("button")) {
            return EnumScoreBoardPaneType.BUTTON;
        }

        if (type.equals("image")) {
            return EnumScoreBoardPaneType.IMAGE;
        }
        //TODO implement rest of the cases

        return null;
    }
}
