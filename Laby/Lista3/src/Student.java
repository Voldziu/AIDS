public class Student {
    int indexNo;
    double scholarship;

    public Student(int nr, double value) {
        indexNo = nr;
        scholarship = value;
    }

    public void increaseScholarship(double value) {
        scholarship += value;
    }

    @Override

    public String toString() {
        return String.format("%6d %8.2f\n", indexNo, scholarship);
    }

    public boolean equals(Student stud) {
        return indexNo == stud.indexNo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return equals((Student) obj);
    }
}