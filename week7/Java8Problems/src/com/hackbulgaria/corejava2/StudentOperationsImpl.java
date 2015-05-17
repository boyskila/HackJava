package com.hackbulgaria.corejava2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.hackbulgaria.corejava2.data.Gender;
import com.hackbulgaria.corejava2.data.Student;

public class StudentOperationsImpl implements StudentOperations {
    List<Student> students;

    public StudentOperationsImpl(List<Student> students) {
        this.students = students;
    }

    @Override
    public double getAverageMark() {
        return students.stream().mapToDouble(s -> s.getGrade()).average().getAsDouble();
    }

    @Override
    public List<Student> getAllPassing() {
        return students.stream().filter(s -> s.getGrade() > 3).collect(Collectors.toList());
    }

    @Override
    public List<Student> getAllFailing() {
        return students.stream().filter(s -> s.getGrade() < 3).collect(Collectors.toList());
    }

    @Override
    public Map<Boolean, List<Student>> splitStudentsByMarks(float splitMark) {
        return students.stream().collect(Collectors.partitioningBy(s -> s.getGrade() >= splitMark));
    }

    @Override
    public List<Student> orderByMarkDescending() {
        return students.stream().sorted((s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> orderByMarkAscending() {
        return students.stream().sorted((s1, s2) -> Double.compare(s1.getGrade(), s2.getGrade()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> getStudentsWithLowestMarks() {
        return students.stream().filter(s -> s.getGrade() < 3).collect(Collectors.toList());
    }

    @Override
    public List<Student> getStudentsWithHighestMarks() {
        return students.stream().filter(s -> s.getGrade() == 6).collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Double>> getMarksDistributionByAge() {
        return students.stream().collect(
                Collectors.groupingBy(Student::getAge, Collectors.mapping(Student::getGrade, Collectors.toList())));
    }

    @Override
    public Map<Gender, Double> getAverageMarkByGender() {
        return students.stream().collect(
                Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(Student::getGrade)));
    }

    @Override
    public Map<Double, Long> getMarksDistribution() {
        return students.stream().collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()));
    }

    @Override
    public String getEmailToHeader() {
        return students.stream().map(Student::getEmail).collect(Collectors.joining(", "));
    }

    @Override
    public Map<Gender, Map<Integer, List<Student>>> splitStudentMarksByGenderAndThenByAge() {

        return students.stream().collect(
                Collectors.groupingBy(Student::getGender, Collectors.groupingBy(Student::getAge, Collectors.toList())));
    }
}
