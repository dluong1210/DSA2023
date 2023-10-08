public class JavaSort {
    class Student {
        private int id;
        private String fname;
        private double cgpa;
        public Student(int id, String fname, double cgpa) {
            super();
            this.id = id;
            this.fname = fname;
            this.cgpa = cgpa;
        }
        public int getId() {
            return id;
        }
        public String getFname() {
            return fname;
        }
        public double getCgpa() {
            return cgpa;
        }
    }

    //Complete the code
    public class Solution
    {
        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int testCases = Integer.parseInt(in.nextLine());

            List<Student> studentList = new ArrayList<Student>();
            while(testCases>0){
                int id = in.nextInt();
                String fname = in.next();
                double cgpa = in.nextDouble();

                Student st = new Student(id, fname, cgpa);
                studentList.add(st);

                testCases--;
            }

            for (int i = 0; i < studentList.size(); i++) {
                for (int j = i + 1; j < studentList.size(); j++) {
                    if (studentList.get(i).getCgpa() > studentList.get(j).getCgpa()) continue;
                    if (studentList.get(i).getCgpa() < studentList.get(j).getCgpa()) Collections.swap(studentList, i, j);
                    else {
                        for (int k = 0; k <= studentList.get(i).getFname().length(); k++) {
                            if (k == studentList.get(i).getFname().length()) {
                                if (studentList.get(i).getId() > studentList.get(j).getId()) Collections.swap(studentList, i, j);
                            } else if (studentList.get(i).getFname().charAt(k) > studentList.get(j).getFname().charAt(k)) {
                                Collections.swap(studentList, i, j);
                                break;
                            } else if (studentList.get(i).getFname().charAt(k) < studentList.get(j).getFname().charAt(k))
                                break;
                        }
                    }
                }
            }

            for(Student st: studentList){
                System.out.println(st.getFname());
            }
        }
    }
}