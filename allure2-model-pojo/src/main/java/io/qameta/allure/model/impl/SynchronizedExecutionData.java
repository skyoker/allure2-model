package io.qameta.allure.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import io.qameta.allure.model.Attachment;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.model.WithAttachments;
import io.qameta.allure.model.WithSteps;

public abstract class SynchronizedExecutionData implements WithAttachments, WithSteps {

  protected List<StepResult> steps;
  protected List<Attachment> attachments;

  public List<StepResult> getSteps() {
      if (steps == null) {
          steps = Collections.synchronizedList(new ArrayList<StepResult>()) ;
      }
      return steps;
  }

  public void setSteps(List<StepResult> steps) {
      this.steps = steps;
  }

  public List<Attachment> getAttachments() {
      if (attachments == null) {
          attachments = Collections.synchronizedList(new ArrayList<Attachment>());
      }
      return attachments;
  }

  public void setAttachments(List<Attachment> attachments) {
      this.attachments = attachments;
  }

  public SynchronizedExecutionData withSteps(StepResult... values) {
      if (values!= null) {
          for (StepResult value: values) {
              getSteps().add(value);
          }
      }
      return this;
  }

  public SynchronizedExecutionData withSteps(Collection<StepResult> values) {
      if (values!= null) {
          getSteps().addAll(values);
      }
      return this;
  }

  public SynchronizedExecutionData withSteps(List<StepResult> steps) {
      setSteps(steps);
      return this;
  }

  public SynchronizedExecutionData withAttachments(Attachment... values) {
      if (values!= null) {
          for (Attachment value: values) {
              getAttachments().add(value);
          }
      }
      return this;
  }

  public SynchronizedExecutionData withAttachments(Collection<Attachment> values) {
      if (values!= null) {
          getAttachments().addAll(values);
      }
      return this;
  }

  public SynchronizedExecutionData withAttachments(List<Attachment> attachments) {
      setAttachments(attachments);
      return this;
  }
}
