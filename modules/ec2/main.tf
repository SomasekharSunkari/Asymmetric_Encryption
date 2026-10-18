# data "aws_ami" "ubuntu" {
#   most_recent = true

#   filter {
#     name   = "name"
#     values = ["ubuntu/images/hvm-ssd/ubuntu-jammy-22.04-amd64-server-*"]
#   }

#   filter {
#     name   = "virtualization-type"
#     values = ["hvm"]
#   }

#   owners = ["099720109477"] # Canonical
# }


# data "aws_vpc" "default-vpc" {

#   default = true

# }

data "aws_subnets" "subntes" {
  filter {
    name   = "vpc-id"
    values = ["vpc-06eac3af3da91f666"]
  }

}

data "aws_subnet" "subnet" {
  id = sort(data.aws_subnets.subntes.ids)[0]
}

resource "aws_instance" "linux-machine" {

  tags = {
    Name        = var.name
    Environment = var.Environment
  }
  ami = var.ami_id

  instance_type = var.instance_type
  subnet_id     = data.aws_subnet.subnet.id

  lifecycle {
    prevent_destroy       = true
    create_before_destroy = true
    ignore_changes        = [tags]
  }

}
