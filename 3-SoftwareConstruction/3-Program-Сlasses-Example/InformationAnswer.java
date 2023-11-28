package com.lab9.airclearstatechecker.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "informationanswer")
public class InformationAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "answer_title")
    private String answerTitle;
    @Column(name = "answer")
    private String answer;
    @Column(name = "file")
    private String file;
    @Column(name = "date")
    private LocalDate date;
    @OneToOne
    @JoinColumn(name = "information_request")
    private InformationRequest InformationRequest;
    @OneToOne
    @JoinColumn(name = "officeemployeeno")
    private OfficeEmployee OfficeEmployee;

    public InformationAnswer(String answerTitle, String answer, String file, LocalDate date, InformationRequest InformationRequest, OfficeEmployee OfficeEmployee) {
        this.answerTitle = answerTitle;
        this.answer = answer;
        this.file = file;
        this.date = date;
        this.InformationRequest = InformationRequest;
        this.OfficeEmployee = OfficeEmployee;
    }

    public InformationAnswer() {

    }

    @Override
    public String toString() {
        return "InformationAnswer{" +
                "id=" + id +
                ", answerTitle='" + answerTitle + '\'' +
                ", answer='" + answer + '\'' +
                ", file=" + file +
                ", date=" + date +
                ", InformationRequest=" + InformationRequest +
                ", OfficeEmployee=" + OfficeEmployee +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswerTitle() {
        return answerTitle;
    }

    public void setAnswerTitle(String answerTitle) {
        this.answerTitle = answerTitle;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getFile() {
        return file;
    }

    public void setFile(LocalDate file) {
        this.file = file;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public InformationRequest getInformationRequest() {
        return informationRequest;
    }

    public void setInformationRequest(InformationRequest informationRequest) {
        this.InformationRequest = InformationRequest;
    }

    public OfficeEmployee getOfficeEmployee() {
        return OfficeEmployee;
    }

    public void setOfficeEmployee(OfficeEmployee OfficeEmployee) {
        this.OfficeEmployee = OfficeEmployee;
    }
}
