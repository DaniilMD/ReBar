import java.util.List;

public class ReBarData {

    private final List<ElementData> elementDataList;
    private final int reBarLength;

    public ReBarData(List<ElementData> elementDataList, int reBarLength) {
        this.elementDataList = elementDataList;
        this.reBarLength = reBarLength;
    }

    public List<ElementData> getElementDataList() {
        return elementDataList;
    }

    public int getReBarLength() {
        return reBarLength;
    }
}
