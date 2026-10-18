output "ec2_arn" {
  value = aws_instance.linux-machine.id
}

output "subnet_id" {

  value       = aws_instance.linux-machine.subnet_id
  description = "Private IP"
}

output "private_ip" {
  value = aws_instance.linux-machine.private_ip

}
