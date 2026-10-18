module "ec2_deploy" {
  source        = "./modules/ec2"
  name          = "ec2-terraform"
  instance_type = "t3.micro"
  Environment   = local.env

  ami_id = local.ami_id
}
