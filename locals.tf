locals {

  Name    = "Sekhar"
  project = "AWS-CICD"
  tags = {
    Name = local.Name
  }
  env    = "Dev"
  ami_id = "ami-06259b63260eddc13"
}

