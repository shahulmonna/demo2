import com.test.Person
import com.test.Role
import com.test.User
import com.test.UserRole

class BootStrap {

	def init = { servletContext ->
		/*def role = new Role(authority: 'ROLE_ADMIN').save()
		def roleAnonymous = new Role(authority: 'ROLE_ANONYMOUS').save()*/

		def data = [['syed', 'shahul', 30, 'syed.shahul@gmail.com'], ['monna', 'shahul', 30, 'monna.shahul@gmail.com']]
		data.each{ record ->
			new Person(firstName: record[0],
					lastName: record[1],
					age: record[2],
					email: record[3]
			).save()

/*
			def u = new User(username: record[3], password: record[0]).save()
			UserRole.create(u, role)*/
		}


	}
	def destroy = {}
}
