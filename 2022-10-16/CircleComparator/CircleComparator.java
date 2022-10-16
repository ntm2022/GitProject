package com.codegym;

import java.util.Comparator;

//bài này khác ở chỗ thay vì extends lớp Circle thì lấy Circle làm đối số (kiểu dữ liệu) -> generic???
public class CircleComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }
}
